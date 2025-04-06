def trivy_fs(){
  sh "trivy fs . -o result.json"
}
