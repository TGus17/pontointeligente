package com.oliva.pontointeligente.services

import com.oliva.pontointeligente.documents.Empresa

interface EmpresaService {
    fun buscarPorCnpj(cnpj: String): Empresa?
    fun pesistir(empresa: Empresa): Empresa
}