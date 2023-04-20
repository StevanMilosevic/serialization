# serialization / deserialization

Serijalizacija je mehanizam pretvaranja objekta u stream bajtova, deserijalizacija je obrnut proces, koji stvara objekat u memoriji
		
Ova konverzija objekata omogucava da oni mogu da se salju preko mreze, da se cuvaju u fajlu ili u bazi podataka zbog neke kasnije upotrebe, takodje je serijalizovanje neophodno zbog <b>RMI</b> (Remote Method Invocation). RMI omogucava da objekat na jednoj masini pozove metodu objekta na drugoj masini.
Stream bajtova se cuva u fajlu sa .SER ekstenzijom, koji kao takav je nezavistan od platforme na kojoj se koristi.

<b>Interfejs Serializable:</b>

Serializable je prazan interfejs, nema nikakva polja ni metode. On omogucava serijalizovanje za one klase koje ga implementiraju. 
Sve potklase od klase koja implementira interfejs Serializable takodje mogu da budu serijalizovane.

<b>Klase FileOutputStream i ObjectOutputStream</b>:

predstavljaju izlazni tok podataka, pomocu koga mozemo da upisujemo bajtove u datoteke. Za izradu objekta <i>FileOutputStream</i> nije potrebno da zadata datoteka postoji, objekat ce je sam napraviti i otvoriti za upisivanje.

<b>Klase FileInputStream i ObjectInputStream</b>:

Prave objekat koji omogucava ucitavanje bajtova iz datoteke

<b>Koraci za Serijalizaciju:</b> 
1. Klasa mora da implementira Serializable interfejs
2. <i>FileOutputStream fos = new FileOutputStream(fajl)</i>
3. <i>ObjectOutputStream oos = new ObjectOutputStream(fos)</i>
4. oos.writeObject(object_za_serijalizaciju)

<b>Koraci za deserijalizaciju:</b>
1. napraviti identicnu klasu u novom projektu za deserijalizaciju
2. deklarisati objekat, ne instancirati ga
3. <i>FileInputSream fis = new FileInputStream(putanja_do_fajla)</i>
4. <i>ObjectInputStrean ois = ObjectInputStream(fis)</i>
5. objectName = (Class)ois.readObject() -> mora da se kastuje kao tip klase koju hocemo da deserijalizujemo zato sto tip klase koja se deserijalizuje nije zabelezen pa mi moramo to da naznacimo

<b>serialVersionUID</b>:

Ovo je jedinstvena verzija ID-a za klasu koja moze da se serijalizuje. On funkcionise kao broj verzije te konkretne serijalizacije, on potvrdjuje da posiljalac i primalac serijalizovanog objekta imaju identicne klase za taj objekat i omogucava da taj objekat bude kompatibilan izmedju razlicitih masina. 
SerialVersionUID se na obe strane serijalizacije mora poklapati, inace ce biti ispaljena greska <b>InvalidClassException</b>.
On se racuna na osnovu osobina klase, njenih polja, clanova itd ali mi mozemo da deklarisemo nas SerialVersionUID rucno kao <b>private static final long</b> polje:

<i>private static final long serialVersionUID = 1L;</i> 

Da bi smo videli koji je serialVersionUID, koristimo <b>ObjectStreamClass</b>:

<i>long serialVersionUID = ObjectStreamClass.lookup(serijal_obj.getClass()).getSerialVersionUID();</i>

<b>modifikatori STATIC i TRANSIENT</b>

Staticka polja se ne serijalizuju, jer ona pripadaju klasi a ne objektu.<br>Transient polja se takodje ne serijalizuju, ona ce biti ignorisana. 
