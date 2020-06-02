INSERT INTO public.localisation(
	id_localisation, localite, pays, region)
	VALUES (1, 'nd', 'nd', 'nd');

INSERT INTO public.utilisateur(
	id_utilisateur, photo_profil, nom, prenom, pseudo, type, version)
	VALUES (1, null, 'nd', 'nd', 'compte fermé', 'USER', 1);

INSERT INTO public.localisation(
	id_localisation, localite, pays, region)
	VALUES (100, 'france', 'normandie', 'petaouch');

INSERT INTO public.utilisateur(
	id_utilisateur, photo_profil, nom, prenom, pseudo, type, version)
	VALUES (100, null, null, null, 'annis', 'ADMIN', 1);
	
INSERT INTO public.animal(
	id_animal, description, emplacement_image, nom_courant, nom_scientifique, ordre)
	VALUES (100, 'cest un chat', null, 'chat', null, null);	
	
INSERT INTO public.animal(
	id_animal, description, emplacement_image, nom_courant, nom_scientifique, ordre)
	VALUES (101, 'cest un chien', null, 'chien', null, null);	

INSERT INTO public.animal(
	id_animal, description, emplacement_image, nom_courant, nom_scientifique, ordre)
	VALUES (102, 'cest un souris', null, 'souris', null, null);	

	
INSERT INTO public.observation(
	id_observation, date_observation, description, nombre, animal, localisation, utilisateur)
	VALUES (100, '31-12-1998', 'c est un chat  qui court', 3, 100, 100, 100);

INSERT INTO public.observation(
	id_observation, date_observation, description, nombre, animal, localisation, utilisateur)
	VALUES (101, '31-12-1998', 'c est un chien  qui court', 3, 101, 100, 100);
	
	INSERT INTO public.observation(
	id_observation, date_observation, description, nombre, animal, localisation, utilisateur)
	VALUES (102, '31-12-1998', 'c est une souris qui court', 3, 102, 100, 100);
	
	