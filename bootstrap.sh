mvn io.quarkus:quarkus-maven-plugin:create \
-DprojectGroupId=org.gs \
-DprojectArtifactId=quarkus-jwt-auth \
-DprojectVersion=1.0.0-SNAPSHOT \
-Dextensions="quarkus-resteasy, quarkus-resteasy-jsonb, quarkus-smallrye-openapi"

cd amazon-cart
mvn quarkus:add-extension -Dextensions="smallrye-jwt"

cd ../amazon-jwt
mvn quarkus:add-extension -Dextensions="smallrye-jwt-build"