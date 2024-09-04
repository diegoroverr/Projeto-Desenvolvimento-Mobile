# Jogo Android
O jogo é um simples aplicativo Android que simula uma jornada onde o usuário precisa clicar em um botão para avançar até completar a tarefa. O aplicativo foi desenvolvido em Kotlin e utiliza elementos básicos da interface do usuário, como ImageView, TextView, Button, e LinearLayout.

## Funcionalidades
- **Progresso da Jornada:** O usuário clica no botão "Avançar" para progredir em sua jornada. O progresso é indicado por diferentes imagens e mensagens.
- **Sistema de Desistência:** O usuário pode optar por desistir a qualquer momento, o que revelará opções para reiniciar a jornada ou sair do aplicativo.
- **Reinício do Jogo:** Após desistir, o usuário pode optar por tentar novamente, reiniciando o progresso.

## Estrutura do Projeto
- **MainActivity:** Esta é a atividade principal onde toda a lógica do aplicativo é implementada.
- **Recursos de Imagem:** As imagens utilizadas para representar os diferentes estágios da jornada devem ser colocadas na pasta res/drawable com os seguintes nomes:
- imagem_inicial.png - Imagem inicial da jornada.
- imagem_progresso.png - Imagem que representa progresso intermediário.
- imagem_quase.png - Imagem que indica que o usuário está quase completando a jornada.
- imagem_completa.png - Imagem que aparece ao completar a jornada.
- imagem_desistiu.png - Imagem que aparece quando o usuário desiste.

## Como Funciona
1. **Avançando na Jornada:**
- O usuário clica no botão "Avançar".
- Dependendo do número de cliques, diferentes imagens e mensagens são exibidas para indicar o progresso.

2. **Desistindo da Jornada:**
- O usuário pode clicar no botão "Desistir" a qualquer momento.
- Isso exibe uma mensagem de desistência e oferece as opções "Sim" para reiniciar ou "Não" para fechar o aplicativo.

3. **Reiniciando o Jogo:**
- Se o usuário optar por reiniciar após desistir, o jogo será reiniciado, e o progresso será redefinido.

## Requisitos
- Android Studio (versão mais recente recomendada).
- Kotlin (compatível com o Android Studio).
- Imagens no formato .png para serem utilizadas no aplicativo.

## Instalação e Execução
1. Clone este repositório:
git clone https://github.com/diegoroverr/Projeto-Desenvolvimento-Mobile.git
2. Abra o projeto no Android Studio.
3. Adicione suas imagens à pasta res/drawable.
4. Compile e execute o aplicativo em um emulador ou dispositivo físico.

## Contribuição
Se você deseja contribuir com este projeto:
1. Faça um fork do repositório.
2. Crie uma branch para sua feature (git checkout -b feature/nova-feature).
3. Commit suas mudanças (git commit -m 'Adiciona nova feature').
4. Faça um push para a branch (git push origin feature/nova-feature).
5. Abra um Pull Request.
