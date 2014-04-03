#!/bin/bash

gimli -r -o ./build
cd ./build
pdftk \
	stark.pdf \
	purpose.pdf \
	objectives.pdf \
	responsibilities.pdf \
	overview.pdf \
	planning.pdf \
	design.pdf \
	review.pdf \
	implementation.pdf \
	qa.pdf \
	appendix.pdf \
	time.pdf \
	cat output team_project.pdf