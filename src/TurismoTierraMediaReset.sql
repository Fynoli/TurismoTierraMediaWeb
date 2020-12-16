BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "usuario" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT NOT NULL,
	"idtipoatraccion"	INTEGER NOT NULL,
	"presupuesto"	INTEGER,
	"tiempo_disponible"	INTEGER,
	"password"	BLOB,
	"activo"	INTEGER DEFAULT 1,
	"profile_pic"	TEXT,
	"esadmin"	INTEGER DEFAULT 0,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("idtipoatraccion") REFERENCES "tipo_atraccion"("id")
);
CREATE TABLE IF NOT EXISTS "tipo_descuento_promocion" (
	"tipo_descuento_promocion_id"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL,
	PRIMARY KEY("tipo_descuento_promocion_id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "promocion_atraccion" (
	"atraccion_id"	INTEGER NOT NULL,
	"promocion_id"	INTEGER NOT NULL,
	PRIMARY KEY("atraccion_id","promocion_id"),
	FOREIGN KEY("atraccion_id") REFERENCES "atraccion"("id"),
	FOREIGN KEY("promocion_id") REFERENCES "promocion"("promocion_id")
);
CREATE TABLE IF NOT EXISTS "atraccion" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT,
	"descripcion"	TEXT,
	"costo"	INTEGER,
	"tiempo"	NUMERIC,
	"cupo"	INTEGER,
	"tipo_id"	INTEGER NOT NULL,
	"activo"	INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("tipo_id") REFERENCES "tipo_atraccion"("id")
);
CREATE TABLE IF NOT EXISTS "tipo_atraccion" (
	"id"	INTEGER NOT NULL,
	"nombre"	INTEGER,
	"activo"	INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "promocion" (
	"promocion_id"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL DEFAULT 'Sin nombre',
	"descripcion"	TEXT NOT NULL DEFAULT 'Sin descripcion',
	"costo"	INTEGER NOT NULL DEFAULT 0,
	"tiempo"	NUMERIC NOT NULL DEFAULT 0,
	"activo"	INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY("promocion_id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "detalle_itinerario" (
	"id"	INTEGER NOT NULL,
	"usuario_id"	INTEGER NOT NULL,
	"atraccion_id"	INTEGER NOT NULL,
	"promo_id"	INTEGER,
	PRIMARY KEY("id"),
	FOREIGN KEY("promo_id") REFERENCES "promocion"("promocion_id"),
	FOREIGN KEY("usuario_id") REFERENCES "usuario"("id"),
	FOREIGN KEY("atraccion_id") REFERENCES "atraccion"("id")
);
INSERT INTO "usuario" VALUES (1,'Frodo',1,50,50,'frodo123',1,'',0);
INSERT INTO "usuario" VALUES (2,'Gandalf',3,50,50,'gandalf123',1,NULL,0);
INSERT INTO "usuario" VALUES (3,'Sam',2,50,50,'sam123',1,NULL,0);
INSERT INTO "usuario" VALUES (4,'Flor',1,50,50,'flor123',1,NULL,1);
INSERT INTO "tipo_descuento_promocion" VALUES (1,'Porcentual');
INSERT INTO "tipo_descuento_promocion" VALUES (2,'AxB');
INSERT INTO "tipo_descuento_promocion" VALUES (3,'Absoluto');
INSERT INTO "promocion_atraccion" VALUES (8,1);
INSERT INTO "promocion_atraccion" VALUES (4,1);
INSERT INTO "promocion_atraccion" VALUES (2,2);
INSERT INTO "promocion_atraccion" VALUES (5,2);
INSERT INTO "promocion_atraccion" VALUES (7,2);
INSERT INTO "promocion_atraccion" VALUES (6,3);
INSERT INTO "promocion_atraccion" VALUES (3,3);
INSERT INTO "atraccion" VALUES (1,'Moria','Atracción',10,2,6,1,1);
INSERT INTO "atraccion" VALUES (2,'Minas Tirith','Atracción',5,2.5,25,3,1);
INSERT INTO "atraccion" VALUES (3,'La Comarca','Atracción',3,2.5,150,2,1);
INSERT INTO "atraccion" VALUES (4,'Mordor','Atracción',25,3,4,1,1);
INSERT INTO "atraccion" VALUES (5,'Abismo Helm','Atracción',5,2,15,3,1);
INSERT INTO "atraccion" VALUES (6,'Lothlorien','Atracción',35,1,30,2,1);
INSERT INTO "atraccion" VALUES (7,'Erebor','Atracción',12,3,32,3,1);
INSERT INTO "atraccion" VALUES (8,'Bosque Negro','Atracción',3,4,12,1,1);
INSERT INTO "tipo_atraccion" VALUES (1,'Aventura',1);
INSERT INTO "tipo_atraccion" VALUES (2,'Degustación',1);
INSERT INTO "tipo_atraccion" VALUES (3,'Paisaje',1);
INSERT INTO "promocion" VALUES (1,'Pack aventura','Bosque Negro y Mordor con un 20% de descuento si se compran ambas.',12,7,1);
INSERT INTO "promocion" VALUES (2,'Pack paisajes','Comprando Minas Tirith y el Abismo de Helm, Erebor es gratis.',10,7.5,1);
INSERT INTO "promocion" VALUES (3,'Pack degustación','Lothlórien y La Comarca a 36 monedas.',36,3.5,1);
INSERT INTO "promocion" VALUES (4,'','',0,0,0);
INSERT INTO "detalle_itinerario" VALUES (1,1,8,1);
INSERT INTO "detalle_itinerario" VALUES (2,1,4,1);
INSERT INTO "detalle_itinerario" VALUES (3,2,6,3);
INSERT INTO "detalle_itinerario" VALUES (4,1,3,3);
INSERT INTO "detalle_itinerario" VALUES (5,1,2,2);
INSERT INTO "detalle_itinerario" VALUES (6,1,5,2);
INSERT INTO "detalle_itinerario" VALUES (7,3,7,2);
INSERT INTO "detalle_itinerario" VALUES (8,4,1,4);
INSERT INTO "detalle_itinerario" VALUES (9,4,3,3);
INSERT INTO "detalle_itinerario" VALUES (10,4,6,3);
COMMIT;
