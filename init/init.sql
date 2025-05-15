USE [master];
GO

IF NOT EXISTS(SELECT * FROM sys.databases WHERE name = 'arq-api_01')
  BEGIN
    CREATE DATABASE [arq-api_01]
  END