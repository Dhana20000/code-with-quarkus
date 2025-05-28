This Project is guide throug the Implementing the JWT authentication in quarksu

For this implementation I creatd the ssl private and public keys using openSSL. The process is give below 
  1. Open SSL installation in windows (https://youtu.be/1FhQR3LkXVA?si=I6o0yizlS6rN-N3t)
  2. Generate the key by using below commands 
      # Generate a new PKCS#8 private key
      openssl genpkey -algorithm RSA -out privateKey.pem -pkeyopt rsa_keygen_bits:2048

      # Extract the public key
      openssl rsa -pubout -in privateKey.pem -out publicKey.pem

I kept te=he files in src/resource folder for referance 
