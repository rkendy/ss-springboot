# Script importacao banco antigo para banco novo:
# 01. Alterar nome do banco no dump
# 02. Drop: drop database `ss-spring-react`;
# 03. Importar: mysql -u root -p < sol_20191101.sql
# 04. Rodar script: mysql -u root -p ss-spring-react < rename.sql
# 05. Limpar tabelas de backup