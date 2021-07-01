package com.pucrs.servEstoque.adaptadores.repositorios;

import java.util.List;
import java.util.Optional;

import com.pucrs.servEstoque.negocio.entidades.ItemEstoque;
import com.pucrs.servEstoque.negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public class EstoqueRepImpl implements IEstoqueRepository{

    EstoqueRepImplJPA jpa;

    @Autowired
    public EstoqueRepImpl(EstoqueRepImplJPA jpa){
        this.jpa = jpa;
    }

    public List<ItemEstoque> todos() {
        return (List<ItemEstoque>) jpa.findAll();
    }

    public void adicionaItem(ItemEstoque item) {
        jpa.save(item);
    }

    @Query("update Item c set c.name = :name WHERE c.id = :customerId")
    public void setCustomerName(@Param("customerId") Long id, @Param("name") String name){

    }

    public boolean baixa(ItemEstoque item, int quantidade) {
        Optional<ItemEstoque> optionalItem = jpa.findById(item.getId());
        ItemEstoque itemAchado = optionalItem.get();
        if(itemAchado.getQuantidadeDisponivel() < quantidade){
            return false;
        }
        itemAchado.setQuantidadeDisponivel(itemAchado.getQuantidadeDisponivel() - quantidade);
        jpa.save(itemAchado);
        return true;
    }

    public void adicionaQtd(long codigo, int quantidade) {
        List<ItemEstoque> estoque = (List<ItemEstoque>) jpa.findAll();
        ItemEstoque itemModificado = null;
        for(ItemEstoque item : estoque){
            if(codigo == item.getProduto().getCodigo()){
                itemModificado = item;
            }
        }
        if(itemModificado != null){
            itemModificado.setQuantidadeDisponivel(itemModificado.getQuantidadeDisponivel() + quantidade);
            jpa.save(itemModificado);
        }
    }
}
