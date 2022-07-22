#!/bin/bash
DIR_PROJECT="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"/../.. #
(cd $DIR_PROJECT; sbt clean assembly; java -jar target/scala-3.1.2/fibonacci-sbt-uberjar.jar pl.tomaszgigiel.fibonacci.ScalaApp src/test/resources/custom.edn;cd -) #
