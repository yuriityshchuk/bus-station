echo "Installing apache"
sudo apt -y update
sudo apt-get install -y apache2
echo "ServerName localhost" | sudo tee /etc/apache2/conf-available/servername.conf
sudo service apache2 reload