package com.oliva.pontointeligente.services.impl

import com.oliva.pontointeligente.documents.Empresa
import com.oliva.pontointeligente.repositories.EmpresaRepository
import com.oliva.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {
    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun pesistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}