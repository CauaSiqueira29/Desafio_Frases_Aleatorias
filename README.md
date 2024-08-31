## Desafio para pegar frases aleatórias
- O objetivo desse desafio era criar um gerador de frases aleatórias com java utilizando SpringBoot Web, como pedido pelo desafio, fiz o gerador, mas de uma forma diferente como foi mostrado na resolução, utilizei streams para buscar uma frase aleatória, além disso, fui além e fiz um CRUD completo (POST, GET, PUT e DELETE), mostrarei aqui como fiz o código.
##

Esse método foi como eu fiz o buscador, está retornando um FraseDto, que possui o título da frase, a própria frase, o personagem que falou e o poster da série/filme/jogos que foi dita, primeiramente ele busca todas as frases e coloca em uma lista, depois verifica se a lista está vazia, jogando uma exceção caso esteja. Nele utilizei o skip(), que está pulando um número aleatório de elementos na lista, após ele, utilizei o findFirst() para pegar o primeiro elemento após o skip(), depois utilizei o map() para mapear o FraseModel no FraseDto e por fim, recupera a frase com um get().
![image](https://github.com/user-attachments/assets/c5dc7c76-0b5d-43b0-94ca-16ca8385fa93)

##

Como dito, além do pedido, que era apenas o buscador, fiz um crud completo, com pastas como Controller, Repository, Dto e Service, para a organização dos arquivos, na aula, a instrutora insere as frases diretamente no banco, mas procurei fazer um endpoint apenas para isso:
<br>![image](https://github.com/user-attachments/assets/fefebd51-1f1b-43e9-b6be-2952421c276f)
<br> Com o método no service:
![image](https://github.com/user-attachments/assets/bd953398-514b-432e-a647-9d944767c42e)
