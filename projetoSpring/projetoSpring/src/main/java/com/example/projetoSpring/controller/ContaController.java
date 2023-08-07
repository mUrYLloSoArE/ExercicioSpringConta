package com.example.projetoSpring.controller;

import com.example.projetoSpring.exceptions.ContaNotFoundException;
import com.example.projetoSpring.models.Conta;
import com.example.projetoSpring.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;
    private Conta conta;



    @ResponseBody
    @GetMapping("/conta")
    public List<Conta> listarContas(){
        return contaRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/conta/{id}")
    public Optional<Conta> listarContaId(@PathVariable Long id){
        return Optional.ofNullable(contaRepository.findById(id).orElseThrow(() -> new ContaNotFoundException("Conta de id " + id +
                " não encontrado!")));
    }

    @ResponseBody
    @PostMapping("/salvar")
    public String salvarConta(@RequestBody Conta conta){
        contaRepository.save(conta);
        return "Conta adicionada!";
    }

    @ResponseBody
    @PutMapping("/depositar/{id}")
    public String depositar(@PathVariable Long id,@RequestBody Conta conta){
        Conta update= contaRepository.findById(id).get();
        update.setValor_final(conta.depositar(update.getValor_final()));
        contaRepository.save(update);
        return "Depósito feito, saldo atualizado!";
    }
    @ResponseBody
    @PutMapping("/sacar/{id}")
    public String sacar(@PathVariable Long id,@RequestBody Conta conta){
        Conta update= contaRepository.findById(id).get();
        update.setValor_final(conta.sacar(update.getValor_final()));
        contaRepository.save(update);
        return "Saque feito, saldo atualizado!";
    }


    @ResponseBody
    @DeleteMapping("/excluir/{id}")
    public  String deletarConta(@PathVariable Long id){
        contaRepository.deleteById(id);
        return "Conta deletada! ";
    }

}
