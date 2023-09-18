package gladiator;

import java.util.Random;

public class NameGenerator
{
	private Random rand;

	public NameGenerator()
	{
		rand = new Random();
	}

	public String firstNameGenerator() // string array was generated with Chat GPT to save time
	{
		String[] arr = { "Julius", "Augustus", "Cicero", "Seneca", "Caligula", "Nero", "Hadrian", "Trajan", "Marcus", "Lucius", "Gaius", "Tiberius", "Antonius", "Brutus", "Pompey", "Livia",
				"Agrippina", "Octavia", "Cornelia", "Cleopatra", "Vitruvius", "Pliny", "Cassius", "Valerius", "Sulla", "Claudius", "Ovid", "Virgil", "Horace", "Livius", "Cato", "Caelius", "Felix",
				"Tertius", "Gallus", "Aemilia", "Claudia", "Fulvia", "Sextus", "Drusus", "Gnaeus", "Octavius", "Sergius", "Hostus", "Quintus", "Appius", "Decimus", "Maximus", "Geminus", "Nerva",
				"Domitian", "Vespasian", "Titus", "Sabinus", "Balbus", "Aurelia", "Tullia", "Aquilina", "Marcellus", "Balbina", "Valeria", "Laelia", "Fabius", "Gallia", "Iulia", "Procopius", "Ostia",
				"Arrius", "Vopiscus", "Spurius", "Minucius", "Octavius", "Quirinus", "Rufus", "Verus", "Fulvius", "Valerian", "Vibia", "Herennius", "Volusia", "Lucilla", "Aurelius", "Galerius",
				"Hostilia", "Gellius", "Tacitus", "Cassia", "Faustina", "Severus", "Hadria", "Camillus", "Maxentius", "Festus", "Hadriana", "Dulcia", "Tacita", "Pacatianus", "Flavia", "Maecenas",
				"Junia", "Quintilianus", "Commodus", "Antonia", "Severina", "Neratia", "Caelina", "Tacitus", "Valentinus", "Crispus", "Didius", "Servius", "Cominius", "Hostilius", "Praetextatus",
				"Cassianus", "Glaucia", "Cornelius", "Petronia", "Vindius", "Catullus", "Drusilla", "Vettius", "Cotta", "Claudianus", "Balbinus", "Titiana", "Albinus", "Cinna", "Appia", "Fadia",
				"Cassiana", "Herennia", "Septimius", "Laelianus", "Vitellia", "Salonina", "Laeliana", "Herennianus", "Licinia", "Tertullianus", "Placidia", "Varius", "Galeriana", "Lucan", "Celsus",
				"Gallus", "Claudiana", "Crassus", "Genucius", "Regulus", "Prisca", "Celsinus", "Sisenna", "Hortensius", "Fabiana", "Sertorius", "Clemens", "Galba", "Helvius", "Valeria", "Velleius",
				"Pupienus", "Trebellius", "Otho", "Mucius", "Rufinus", "Valentia", "Hostilianus", "Trebonius", "Quinctia", "Maelius", "Iunius", "Opellius", "Egnatius", "Statius", "Severus",
				"Glaucius", "Velia", "Lentulus", "Rufinia", "Licinius", "Camillia", "Minucia", "Vestinus", "Corneliana", "Marulla", "Afranius", "Balbus", "Statilia", "Trebonia", "Sextilia",
				"Giovanni", "Caelianus", "Cominia", "Plautilla", "Gratian", "Valentinian", "Valeria", "Severa", "Allectus" };

		return arr[rand.nextInt(arr.length)];
	}

	public String lastNameGenerator()
	{
		String[] arr = { "Fierce", "Mighty", "Brave", "Valiant", "Heroic", "Fearless", "Savage", "Indomitable", "Relentless", "Courageous", "Formidable", "Unyielding", "Stalwart", "Resolute",
				"Dauntless", "Tenacious", "Unshakable", "Vigilant", "Unflinching", "Inexorable", "Invincible", "Unwavering", "Audacious", "Battle-hardened", "Inspirational", "Ironclad",
				"Battle-scarred", "Undaunted", "Battle-tested", "Gallant", "Unswerving", "Uncompromising", "Unassailable", "Unconquerable", "Unfaltering", "Unrelenting", "Unyielding", "Fear-inducing",
				"Daring", "Undeterred", "Steadfast", "Resilient", "Impervious", "Unbreakable", "Warrior", "Unscathed", "Unbowed", "Stouthearted", "Dauntless", "Fear-defying", "Iron-willed",
				"Battle-ready", "Fearless", "Invulnerable", "Undisturbed", "Formidable", "Dauntless", "Undefeatable", "Unconquered", "Unstoppable", "Indefatigable", "Indomitable", "Unshaken",
				"Sturdy", "Staunch", "Vanguard", "Unwavering", "Stalwart", "Unswayed", "Steady", "Iron-minded", "Unwavering", "Unbending", "Unbroken", "Voracious", "Unrelenting", "Dauntless",
				"Determined", "Resilient", "Unassailable", "Unshakable", "Unblinking", "Valorous", "Undying", "Resolute", "Tenacious", "Impenetrable", "Unfailing", "Fear-proof", "Undefeated",
				"Unmarred", "Fear-invoking", "Immovable", "Dreadless", "Unshattered", "Unintimidated", "Unimpeachable", "Unscathed", "Undisputed", "Unblemished", "Undamaged", "Unhindered",
				"Untroubled", "Unvanquished", "Unquenchable", "Reliable", "Unrelentable", "Unbroken", "Unweakened", "Unbowed", "Unyielding", "Unstressed", "Unfazed", "Imperturbable", "Impregnable",
				"Unwounded", "Unconquerable", "Unintimidatable", "Indestructible", "Unbeaten", "Unsullied", "Unstinting", "Unhesitating", "Unflagging", "Unafraid", "Ungiving", "Unstirred",
				"Unperturbed", "Untroubled", "Untiring", "Unblinking", "Unspooked", "Undiscouraged", "Unscarred", "Undamaged", "Unvaried", "Unalterable", "Unwavering", "Unflinching", "Untouched",
				"Unaffected", "Unruffled", "Undisturbed", "Unfazed", "Unhurried", "Unworried", "Untroubled", "Unabashed", "Unintimidated", "Unhumbled", "Undauntable", "Unbothered", "Unflappable",
				"Unswervable", "Uninhibited", "Unstoppable", "Unweary", "Unsubdued", "Unwithdrawn", "Unrestrained", "Unyielding", "Untamed", "Unmanageable", "Unmasterable", "Unrepentant",
				"Unremorseful", "Unforgiving", "Unmerciful", "Unrelenting", "Uncompromising" };

		return arr[rand.nextInt(arr.length)];
	}

	public String fullNameGenerator()
	{

		return firstNameGenerator() + " The " + lastNameGenerator();
	}
}
