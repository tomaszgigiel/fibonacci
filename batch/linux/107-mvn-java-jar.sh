#!/bin/bash
DIR_PROJECT="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"/../.. #
(cd $DIR_PROJECT; mvn -U clean package; java -jar target/fibonacci-mvn-jar-with-dependencies.jar pl.tomaszgigiel.fibonacci.JavaApp src/test/resources/custom.edn;cd -) #
