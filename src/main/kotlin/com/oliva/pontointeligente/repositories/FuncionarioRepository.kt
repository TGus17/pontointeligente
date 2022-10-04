package com.oliva.pontointeligente.repositories

import com.oliva.pontointeligente.documents.Funcionario
import org.springframework.data.mongodb.repository.MongoRepository

interface FuncionarioRepository : MongoRepository<Funcionario, String> {
    fun findByEmail(email: String): Funcionario?
    fun findByCpf(cpf: String): Funcionario?
}