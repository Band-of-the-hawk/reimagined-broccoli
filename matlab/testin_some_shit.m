%% Oppgave - dunnoman
close all, clear all;

fileID = fopen('log-files\particleposition_2k1k10k10k10k.csv');
FD_data = textscan(fileID,'%d%d%d%d%d','Delimiter', ',');
fclose(fileID);

watisdis = FD_data{1,1};