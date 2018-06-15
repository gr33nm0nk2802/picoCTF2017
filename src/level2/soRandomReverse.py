#!/usr/bin/python -u
import random, string

flag = ""
encflag = "BNZQ:jn0y1313td7975784y0361tp3xou1g44"
random.seed("random")

for c in encflag:
  if c.islower():
    # Rotate number around alphabet a random amount
    flag += chr((ord(c) - ord('a') - random.randrange(0, 26)) % 26 + ord('a'))
  elif c.isupper():
    flag += chr((ord(c) - ord('A') - random.randrange(0, 26)) % 26 + ord('A'))
  elif c.isdigit():
    flag += chr((ord(c) - ord('0') - random.randrange(0, 10)) % 10 + ord('0'))
  else:
  	flag += c

print "Decrypted Flag: " + flag
