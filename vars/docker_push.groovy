def call(String credId, String imageName) {
    withCredentials([usernamePassword(
        credentialsId: credId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh """
            docker login -u $DOCKER_USER -p $DOCKER_PASS
            docker tag ${imageName} $DOCKER_USER/${imageName}:latest
            docker push $DOCKER_USER/${imageName}:latest
        """
    }
}
