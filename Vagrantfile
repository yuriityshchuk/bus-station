
Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/trusty64"

  #script for installing all things for spring boot project
  #and then running it on port 8080
  config.vm.provision "shell", path: "boot-setup.sh"

  #uncomment if u want to install apache only
  #config.vm.provision "shell" path: "apache-setup.sh"

end
