package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    // Declaração das variáveis para os elementos de interface
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var clickCounterView: TextView // Adicionado: Contador de cliques
    private lateinit var buttonAdvance: Button
    private lateinit var buttonGiveUp: Button
    private lateinit var buttonYes: Button
    private lateinit var buttonNo: Button
    private lateinit var buttonRestart: Button // Adicionado: Botão de reinício

    // Contador de cliques e o número alvo de cliques para completar a jornada
    private var clicks = 0
    private var targetClicks = (1..50).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Se houver um estado salvo, restaura os valores
        savedInstanceState?.let {
            clicks = it.getInt("clicks", 0)
            targetClicks = it.getInt("targetClicks", (1..50).random())
        }

        // Criando o layout principal (vertical, centralizado)
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        // Criando a ImageView e definindo a imagem inicial
        imageView = ImageView(this).apply {
            layoutParams = LinearLayout.LayoutParams(300, 300)
            setImageResource(R.drawable.imagem_inicial) // Imagem inicial da jornada
        }

        // Criando o TextView com uma mensagem inicial
        textView = TextView(this).apply {
            text = "Clique para avançar na sua jornada!"
            textSize = 18f
            gravity = Gravity.CENTER
        }

        // Criando o TextView para o contador de cliques
        clickCounterView = TextView(this).apply {
            text = "Cliques: $clicks / $targetClicks" // Inicializa com o número de cliques e o alvo
            textSize = 16f
            gravity = Gravity.CENTER
        }

        // Criando o botão "Avançar" com lógica para atualizar a jornada
        buttonAdvance = Button(this).apply {
            text = "Avançar"
            setOnClickListener {
                clicks++ // Incrementa o contador de cliques
                clickCounterView.text = "Cliques: $clicks / $targetClicks" // Atualiza o contador de cliques
                when {
                    // Caso tenha completado a jornada
                    clicks >= targetClicks -> {
                        textView.text = "Parabéns! Você completou a jornada!"
                        imageView.setImageResource(R.drawable.imagem_completa) // Imagem final
                        showRestartButton() // Exibe o botão de reinício
                    }
                    // Caso esteja quase completando
                    clicks > targetClicks * 0.66 -> {
                        textView.text = "Você está quase lá!"
                        imageView.setImageResource(R.drawable.imagem_quase) // Imagem de quase lá
                    }
                    // Caso esteja progredindo
                    clicks > targetClicks * 0.33 -> {
                        textView.text = "Continue, você está progredindo!"
                        imageView.setImageResource(R.drawable.imagem_progresso) // Imagem de progresso
                    }
                    // Caso inicial
                    else -> {
                        textView.text = "Clique para avançar na sua jornada!"
                        imageView.setImageResource(R.drawable.imagem_inicial) // Imagem inicial
                    }
                }
            }
        }

        // Criando o botão "Desistir" com lógica para exibir as opções de reinício
        buttonGiveUp = Button(this).apply {
            text = "Desistir"
            setOnClickListener {
                textView.text = "Você desistiu! Deseja tentar novamente?"
                imageView.setImageResource(R.drawable.imagem_desistiu) // Imagem de desistência
                showRestartOptions() // Exibe as opções de reinício
            }
        }

        // Criando o botão "Sim" (para reiniciar o jogo), inicialmente invisível
        buttonYes = Button(this).apply {
            text = "Sim"
            visibility = Button.GONE
            setOnClickListener {
                resetGame() // Reinicia o jogo
            }
        }

        // Criando o botão "Não" (para sair do jogo), inicialmente invisível
        buttonNo = Button(this).apply {
            text = "Não"
            visibility = Button.GONE
            setOnClickListener {
                finish() // Fecha o aplicativo
            }
        }

        // Criando o botão "Reiniciar" (para reiniciar o jogo após a conclusão), inicialmente invisível
        buttonRestart = Button(this).apply {
            text = "Reiniciar"
            visibility = Button.GONE
            setOnClickListener {
                resetGame() // Reinicia o jogo
            }
        }

        // Adicionando os elementos ao layout principal
        mainLayout.addView(imageView)
        mainLayout.addView(textView)
        mainLayout.addView(clickCounterView) // Adicionado: Contador de cliques
        mainLayout.addView(buttonAdvance)
        mainLayout.addView(buttonGiveUp)
        mainLayout.addView(buttonYes)
        mainLayout.addView(buttonNo)
        mainLayout.addView(buttonRestart) // Adicionado: Botão de reinício

        // Definindo o layout principal como a visualização da atividade
        setContentView(mainLayout)
    }

    // Função para exibir as opções de reinício ("Sim" e "Não")
    private fun showRestartOptions() {
        buttonAdvance.visibility = Button.GONE
        buttonGiveUp.visibility = Button.GONE
        buttonYes.visibility = Button.VISIBLE
        buttonNo.visibility = Button.VISIBLE
    }

    // Função para exibir o botão de reinício
    private fun showRestartButton() {
        buttonAdvance.visibility = Button.GONE
        buttonGiveUp.visibility = Button.GONE
        buttonRestart.visibility = Button.VISIBLE
    }

    // Função para reiniciar o jogo, resetando os valores e visualizações
    private fun resetGame() {
        clicks = 0
        targetClicks = (1..50).random()
        textView.text = "Clique para avançar na sua jornada!"
        imageView.setImageResource(R.drawable.imagem_inicial) // Imagem inicial
        clickCounterView.text = "Cliques: $clicks / $targetClicks" // Reseta o contador de cliques
        buttonAdvance.visibility = Button.VISIBLE
        buttonGiveUp.visibility = Button.VISIBLE
        buttonYes.visibility = Button.GONE
        buttonNo.visibility = Button.GONE
        buttonRestart.visibility = Button.GONE // Oculta o botão de reinício
    }

    // Salva o estado da atividade
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("clicks", clicks)
        outState.putInt("targetClicks", targetClicks)
    }
}
