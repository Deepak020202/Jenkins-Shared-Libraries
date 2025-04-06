def docker_push(String credId , String ImageName){
   stage("Push to Docker Hub") {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: "${credId}",
                    usernameVariable: "DockerHubUser",
                    passwordVariable: "DockerHubPass"
                    )]){
                        sh "docker login -u ${env.DockerHubUser} -p ${env.DockerHubPass}"
                        sh "docker image tag ${ImageName} ${env.DockerHubUser}/${ImageName}
                        sh "docker push ${env.DockerHubUser}/flask-app:latest"
                    }
            }
