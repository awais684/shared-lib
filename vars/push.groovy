def call(String ImageName, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerhubcred', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${ImageName}:${ImageTag}"
}
