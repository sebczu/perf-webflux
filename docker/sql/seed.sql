do $$
begin
  for i in 1..1000000 loop
  INSERT INTO movie (title) VALUES ('Avengers');
  end loop;
end;
$$;

 curl -w "total: %{time_total}" -o /dev/null -s "localhost:8080/movies"