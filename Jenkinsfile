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
        sh "nohup python -m http.server 4200 &"
        sleep(3)
      }
     
  }
     stage('Robot') {
            steps {
                
                sh 'robot --variable BROWSER:headlesschrome -d RobotFramework-edit/Results RobotFramework-edit/Tests'
                
            }
            post {
                always {
                    script {
                        step(
                            [
                                $class                  :   'RobotPublisher',
                                outputPath              :   'RobotFramework-edit/Results',
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
                sh 'newman run petclinic.collection --environment petclinic.environment --reporters junit'
            }
            post {
                always {
                        junit '**/*xml'
                    }
                }
        }
 }
}
