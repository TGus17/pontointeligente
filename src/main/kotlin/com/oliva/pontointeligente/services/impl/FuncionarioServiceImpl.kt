package com.oliva.pontointeligente.services.impl

import com.oliva.pontointeligente.documents.Funcionario
import com.oliva.pontointeligente.repositories.FuncionarioRepository
import com.oliva.pontointeligente.services.FuncionarioService
import org.springframework.stereotype.Service

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService{
    override fun persistir(funcionario: Funcionario): Funcionario =
        funcionarioRepository.save(funcionario)

    override fun buscarPorCpf(cpf: String): Funcionario? = funcionarioRepository.findByCpf(cpf)

    override fun buscarPorEmail(email: String): Funcionario? = funcionarioRepository.findByEmail(email)

    override fun buscarPorId(id: String): Funcionario? = funcionarioRepository.findById(id).get()

}