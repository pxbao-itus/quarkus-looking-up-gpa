create table "Student" (

	"StudentId" SERIAL,
	"FirstName" varchar(255),
	"LastName" varchar(255),

	primary key ("StudentId")
);

create table "Subject" (
	"SubjectId" SERIAL,
	"SubjectName" varchar(255),

	primary key ("SubjectId")
);

create table "Score" (
	"StudentId" int,
	"SubjectId" int ,
	"Score" float,

	primary key ("StudentId", "SubjectId")
);


alter table "Score" add constraint FK_Student_Score foreign key ("StudentId") references "Student"("StudentId");

alter table "Score" add constraint FK_Subject_Score foreign key ("SubjectId") references "Subject"("SubjectId");

insert into "Student"("FirstName","LastName") values ('Michael', 'Owen');