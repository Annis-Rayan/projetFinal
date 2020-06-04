INSERT INTO public.login(
	 username, enable, password)
	VALUES ( 'annis', true, 'annis');

INSERT INTO public.login(
	 username, enable, password)
	VALUES ('mec', true, 'mec');
	

INSERT INTO public.localisation(
	id_localisation, localite, pays, region)
	VALUES (1, 'nd', 'nd', 'nd');

INSERT INTO public.utilisateur(
	id_utilisateur, image_profil_id, nom, prenom, pseudo, type, version)
	VALUES (1, null, 'nd', 'nd', 'compte fermé', 'USER', 1);

INSERT INTO public.localisation(
	id_localisation, localite, pays, region)
	VALUES (99, 'france', 'normandie', 'petaouch');

INSERT INTO public.utilisateur(
	id_utilisateur, image_profil_id, nom, prenom, pseudo, type, version)
	VALUES (99, null, null, null, 'annis', 'ADMIN', 1);

INSERT INTO public.animal(
	id_animal, description, emplacement_image, nom_courant, nom_scientifique, ordre)
	VALUES (99, 'cest un chat', null, 'chat', null, null);	
	
INSERT INTO public.animal(
	id_animal, description, emplacement_image, nom_courant, nom_scientifique, ordre)
	VALUES (98, 'cest un chien', null, 'chien', 'nom courant_chien',null);	
INSERT INTO public.animal(
	id_animal, description, emplacement_image, nom_courant, nom_scientifique, ordre)
	VALUES (97, 'cest un souris', null, 'souris', null, null);	

	
INSERT INTO public.observation(
	id_observation, date_observation, description, nombre, animal, localisation, utilisateur)
	VALUES (99, '31-12-1998', 'c est un chat  qui court', 3, 99, 99, 99);

INSERT INTO public.observation(
	id_observation, date_observation, description, nombre, animal, localisation, utilisateur)
	VALUES (98, '31-12-1998', 'c est un chien  qui court', 3, 98, 99, 99);
	
	INSERT INTO public.observation(
	id_observation, date_observation, description, nombre, animal, localisation, utilisateur)
	VALUES (97, '31-12-1998', 'c est une souris qui court', 3, 97, 99, 99);
	
	