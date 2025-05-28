JWT Authentication in Quarkus – Setup Guide

This project demonstrates how to implement **JWT (JSON Web Token) authentication** in a **Quarkus** application using RSA keys for signing and verifying tokens.
🔧 Prerequisites
    * Java 17+ (we Used JAVA 21 in this project)
    * Maven 
    * Quarkus
    * OpenSSL installed (for key generation)

🛠️ Step-by-Step Setup
  1. Install OpenSSL (Windows)
    You can follow the instructions in this video: (https://youtu.be/1FhQR3LkXVA?si=I6o0yizlS6rN-N3t)
  2. Generate RSA Key Pair using OpenSSL
       Open a terminal and run the following commands:
       bash
        # ✅ Generate a 2048-bit RSA private key in PKCS#8 format
        openssl genpkey -algorithm RSA -out privateKey.pem -pkeyopt rsa_keygen_bits:2048
        
        # ✅ Extract the corresponding public key
        openssl rsa -pubout -in privateKey.pem -out publicKey.pem
  3. Place Keys in Your Project

Move both generated files to the following location in your Quarkus project:
    src/main/resources/META-INF/resources/
    ├── privateKey.pem
    └── publicKey.pem
These keys will be used for signing and verifying JWT tokens.

⚙️ Quarkus Configuration (application.properties)

Ensure your `application.properties` contains the following properties:

**properties**
    # JWT Verification Settings
    mp.jwt.verify.issuer=example-issuer
    mp.jwt.verify.publickey.location=META-INF/resources/publicKey.pem
    
    # JWT Generation Settings
    smallrye.jwt.sign.key.location=META-INF/resources/privateKey.pem
    
    # Optional: JWT default lifespan (in seconds)
    # smallrye.jwt.new-token.lifespan=3600
