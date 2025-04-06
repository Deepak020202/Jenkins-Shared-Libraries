
def docker_build(String ImageName){ 

sh "docker build -t "${ImageName}"

}
