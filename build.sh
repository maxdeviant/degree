#!/bin/bash

gimli -r -o ./build
cd ./build
pdftk \
	stark.pdf \
	purpose.pdf \
	objectives.pdf \
	responsibilities.pdf \
	overview.pdf \
	design.pdf \
	implementation.pdf \
	qa.pdf \
	review.pdf \
	cat output team_project.pdf \