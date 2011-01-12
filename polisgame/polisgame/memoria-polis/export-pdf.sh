#!/bin/sh
pdflatex -output-directory=pdf polis.tex 
pdflatex -output-directory=pdf polis.tex
rm pdf/polis.aux
rm pdf/polis.log
rm pdf/polis.toc
