package com.oliva.pontointeligente.services.impl

import com.oliva.pontointeligente.documents.Lancamento
import com.oliva.pontointeligente.repositories.LancamentoRepository
import com.oliva.pontointeligente.services.LancamentoService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {
    override fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest) =
        lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest)

    override fun buscarPorId(id: String) = lancamentoRepository.findById(id).get()

    override fun pesistir(lancamento: Lancamento) = lancamentoRepository.save(lancamento)

    override fun remover(id: String) = lancamentoRepository.deleteById(id)
}