# 更新
apt update

# jdk17
apt install openjdk-17-jdk17

# mysql
apt install mysql-server
# 彻底卸载
sudo apt purge mysql-*
sudo rm -rf /etc/mysql/ /var/lib/mysql
sudo apt autoremove
sudo apt autoclean

# maven
apt install maven

# nginx
apt install nginx -y
# 如果您的 Ubuntu 系统上启用并配置了防火墙，则执行以下 ufw 命令以允许 80 和 443 端口
sudo ufw allow 80/tcp
sudo ufw allow 443/tcp
# 验证
sudo ufw status numbered


# git配置
git config --global user.name "polarisink"
git config --global user.email "polarisink@163.com"
ssh-keygen -t rsa -C "polarisink@163.com"