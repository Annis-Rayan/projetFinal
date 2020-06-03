INSERT INTO public.localisation(
	id_localisation, localite, pays, region)
	VALUES (1, 'nd', 'nd', 'nd');

INSERT INTO public.utilisateur(
	id_utilisateur, photo_profil, nom, prenom, pseudo, type, version)
	VALUES (1, null, 'nd', null,'compte fermé', 'USER', 1);
	
INSERT INTO public.localisation(
	id_localisation, pays, localite, region)
	VALUES (nextval('seq_localisation'), 'france', 'normandie', 'petaouch');

INSERT INTO public.utilisateur(
	id_utilisateur, photo_profil, nom, prenom, pseudo, type, version)
	VALUES (nextval('seq_utilisateur'), null, null, null, 'annis', 'ADMIN', 1);

INSERT INTO public.login(
	username, enable, password)
	VALUES ('annis', true, 'annis');
	
INSERT INTO public.utilisateur(
	id_utilisateur, photo_profil, nom, prenom, pseudo, type, version)
	VALUES (nextval('seq_utilisateur'), null, null, null, 'mec', 'USER', 1);

INSERT INTO public.login(
	username, enable, password)
	VALUES ('mec', true, 'mec');
	
INSERT INTO public.animal(
	id_animal, description, emplacement_image, nom_courant, nom_scientifique, ordre)
	VALUES (nextval('seq_animal'), 'cest un chat', null, 'chat', 'chat nom courant',null);	
	
INSERT INTO public.animal(
	id_animal, description, emplacement_image, nom_courant, nom_scientifique, ordre)
	VALUES (nextval('seq_animal'), 'cest un chien', null, 'chien', null, null);	

INSERT INTO public.animal(
	id_animal, description, emplacement_image, nom_courant, nom_scientifique, ordre)
	VALUES (nextval('seq_animal'), 'cest un souris', null, 'souris', null, null);	

	
INSERT INTO public.observation(
	id_observation, date_observation, description, nombre, animal, localisation, utilisateur)
	VALUES (nextval('seq_obs'), '31-12-1998', 'c est un chat  qui court', 3, 100, 100, 100);

INSERT INTO public.observation(
	id_observation, date_observation, description, nombre, animal, localisation, utilisateur)
	VALUES (nextval('seq_obs'), '31-12-1998', 'c est un chien  qui court', 3, 101, 100, 100);
	
	INSERT INTO public.observation(
	id_observation, date_observation, description, nombre, animal, localisation, utilisateur)
	VALUES (nextval('seq_obs'), '31-12-1998', 'c est une souris qui court', 3, 102, 100, 100);
	
	