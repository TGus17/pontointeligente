package com.oliva.pontointeligente.services

import com.oliva.pontointeligente.documents.Funcionario
import com.oliva.pontointeligente.enums.PerfilEnum
import com.oliva.pontointeligente.repositories.FuncionarioRepository
import com.oliva.pontointeligente.utils.SenhaUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import java.util.*

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureDataMongo
class FuncionarioServiceTest {
    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    @Autowired
    private val funcionarioService: FuncionarioService? = null

    private val email = "email@email.com"
    protected val cpf = "12345678987"
    private val id = "1"

    @BeforeEach
    @Throws(Exception::class)
    fun setup() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java)))
            .willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findById(id)).willReturn(Optional.of(funcionario()))
        BDDMockito.given(funcionarioRepository?.findByEmail(email)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByCpf(cpf)).willReturn(funcionario())
    }

    @Test
    fun testPersistirFuncionario() {
        val funcionario: Funcionario? = this.funcionarioService?.persistir(funcionario())
        Assertions.assertNotNull(funcionario)
    }

    private fun funcionario(): Funcionario =
        Funcionario("Nome", email, SenhaUtils().gerarBcrypt("123456"),
            cpf, PerfilEnum.ROLE_USUARIO, id )
}