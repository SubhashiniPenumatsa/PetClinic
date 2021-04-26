pipeline {
  agent any
  stages {
    
    stage('Build Api') {
      steps {
        sh "nohup mvn spring-boot:run &"
        sleep(20)
      }
    } 
    stage('Build Angular') {
      steps {
        sh "nohup sh "cd spring-petclinic-angular/static-content -- curl https://jcenter.bintray.com/com/athaydes/rawhttp/rawhttp-cli/1.0/rawhttp-cli-1.0-all.jar -o
          rawhttp.jar -- java -jar ./rawhttp.jar serve . -p 4200" &"
        sleep(3)
      }
     
  }
     stage('Robot') {
            steps {
                sh 'cd spring-petclinic-angular/Tests robot --variable BROWSER:headlesschrome -d spring-petclinic-angular/Tests/Results spring-petclinic-angular/Tests'
               
                
            }
            post {
                always {
                    script {
                        step(
                            [
                                $class                  :   'RobotPublisher',
                                outputPath              :   'spring-petclinic-angular/Tests/Results',
                                outputFileName          :   '**/output.xml',
                                reportFileName          :   '**/report.html',
                                logFileName             :   '**/log.html',
                                disableArchiveOutput    :   false,
                                passThreshold           :   100,
                                unstableThreshold       :   40,
                                otherFiles              :   "**/*.png,**/*.jpg",
                            ]
                        )
                    }
                }
            }
     }
    stage('newman') {
            steps {
                sh 'newman run PetClinic.postman_collection.json --environment petsapi.postman_environment.json --reporters junit'
            }
            post {
                always {
                        junit '**/*xml'
                    }
                }
        }
 }
}
