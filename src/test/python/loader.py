#!/usr/bin/python
import urllib
import re
import sys

for i in range (10000):
	print "Opeing URL for the ", i , " th time" 
	f = urllib.urlopen ('http://cloudbeestutorial-prod.tutorial.cloudbees.net')
	s = f.read ()
	print s
	f.close ()
