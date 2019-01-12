Vagrant.configure("2") do |config|

  config.vm.box = "ubuntu/bionic64"

  config.vm.network "forwarded_port", guest: 27017, host: 27017
  config.vm.network "forwarded_port", guest: 3306, host: 3306
  config.vm.network "forwarded_port", guest: 8080, host: 8080

  config.vm.provision "shell" do |s|
    s.inline = "mkdir -p docker/mongo"
    s.inline = "mkdir -p docker/mysql"
  end

  config.vm.provision "docker" do |d|

  	d.build_image "/vagrant",
	   args: "-t pet-clinic --build-arg JAR_FILE=pet-clinic-web/target/pet-clinic-web-0.0.8-SNAPSHOT.jar"

  	d.run "mongo",
	  image: "mongo:latest",
	  args: "-p 27017:27017 -v /home/vagrant/docker/mongo:/data/db"

	d.run "mysql",
	  image: "mysql:latest",
	  args: "-p 3306:3306 -v /home/vagrant/docker/mysql:/var/lib/mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=yes"

	d.run "pet-clinic",
	  image: "pet-clinic:latest",
	  args: "-p 8080:8080"

  end

  config.vm.provision "shell" do |s|
    s.inline = "docker images --quiet --filter=dangling=true | xargs --no-run-if-empty docker rmi"
  end

end