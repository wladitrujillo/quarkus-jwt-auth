mkdir jwt
openssl genrsa -out jwt/rsaPrivateKey.pem 2048
openssl rsa -pubout -in jwt/rsaPrivateKey.pem -out jwt/publicKey.pem
openssl pkcs8 -topk8 -nocrypt -inform pem -in jwt/rsaPrivateKey.pem -outform pem -out jwt/privateKey.pem
cp jwt/publicKey.pem amazon-cart/src/main/resources 
cp jwt/privateKey.pem amazon-jwt/src/main/resources