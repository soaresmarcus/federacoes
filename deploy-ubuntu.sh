#!/bin/bash
# exemplo ./deploy.sh usuariodamquina
if [ $# -eq 0 ]
then
    echo "Argumentos inválidos!"
    exit 1;
fi
usuario=$1

# variáveis
corPadrao="\033[0m"
marrom="\033[0;33m"

NOME_SNAPSHOT="federacoes-0.0.1-SNAPSHOT"
NOME_NOVO_SNAPSHOT="avaliacao"

AMBIENTE="34.74.24.185"

#Para a execução (use ctrl+c)
trap 'exit 0' 2

echo -e "$marrom Removendo arquivos antigos do ambiente $corPadrao"
sudo rm $NOME_NOVO_SNAPSHOT.jar
#sudo rm federacoes.zip

echo -e "$marrom Compilando projeto $corPadrao"
mvn compile
echo -e "$marrom Gerando versao de deploy do ambiente $corPadrao"
mvn clean package -Dmaven.test.skip=true

mv target/$NOME_SNAPSHOT.jar $NOME_NOVO_SNAPSHOT.jar
#zip -r federacoes.zip federacoes


rsync -rvzh --progress $NOME_NOVO_SNAPSHOT.jar $usuario@$AMBIENTE:/tmp

#echo -e "$marrom Enviando arquivo zip para o servidor $corPadrao"
#rsync -rvzh --progress federacoes.zip $usuario@$AMBIENTE:/tmp
