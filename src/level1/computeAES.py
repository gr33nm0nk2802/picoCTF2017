#! /usr/bin/env python3
import base64
from Crypto.Cipher import AES

key = base64.b64decode("zb9v8uGYo/BWzbhouenY2g==")
ciphertext = base64.b64decode("ACw5ftWAMhGPpxkbT1iun8aLQ55rGrYUMjeyZfIlYd8Whz8TwCMg1AgeTA83J7qt	")
crypter = AES.new(key, AES.MODE_ECB)
plaintext = crypter.decrypt(ciphertext).decode("utf-8")

print(plaintext)
