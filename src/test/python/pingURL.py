#!/usr/bin/python
import urllib
import re
import sys

f = urllib.urlopen ('http://cloudbeestutorial.tutorial.cloudbees.net')
s = f.read ()
m = re.search ("Thailand, Bangkok", s)
if m is None:
        print 'Test Failed: Could not find Thailand, Bangkok'
        sys.exit (1)
else:
        print 'Test Successful: Successfully found Thailand, Bangkok'
        sys.exit (0)


