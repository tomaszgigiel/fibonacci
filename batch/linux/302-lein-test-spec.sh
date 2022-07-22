#!/bin/bash
DIR_PROJECT="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"/../.. #
(cd $DIR_PROJECT; lein test :only pl.tomaszgigiel.fibonacci.core-test; cd -) #
