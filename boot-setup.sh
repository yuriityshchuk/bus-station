#!/usr/bin/env bash

sudo apt-get update

echo "Installing Git.."
sudo apt-get install -y git

echo "Installing Maven.."
sudo apt-get install -y maven
sudo apt-get install -y software-properties-common python-software-properties
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections

echo "Installing Java 8.."
sudo add-apt-repository -y ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get install -y openjdk-8-jdk

echo "Setting environment variables for Java 8.."
sudo apt-get install -y openjdk-8-set-default
export MAVEN_OPTS='-Xmx512m -XX:MaxPermSize=128m'

git clone https://github.com/yuriityshchuk/bus-station.git
cd bus-station
./mvnw spring-boot:run