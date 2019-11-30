#!/bin/bash

# variáveis
corPadrao="\033[0m"
marrom="\033[0;33m"

NOME_SNAPSHOT="federacoes-0.0.1-SNAPSHOT"

#Para a execução (use ctrl+c)
trap 'exit 0' 2

echo -e "$marrom Compilando projeto $corPadrao"
mvn clean
mvn compile
echo -e "$marrom Gerando versao de deploy do ambiente $corPadrao"
mvn package -Dmaven.test.skip=true

java -jar target/$NOME_SNAPSHOT.jar & (cd federacoes && ng serve --disable-host-check)