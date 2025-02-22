package com.rajveer.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title: String = "",
    @ColumnInfo(name = "wish-desc")
    val description: String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(1, "Apple Vision Pro", "A mixed-reality headset for immersive experiences."),
        Wish(2, "Meta Quest 3", "A standalone VR headset with enhanced mixed reality capabilities."),
        Wish(3, "Samsung Galaxy S23 Ultra", "A high-end smartphone with a powerful camera system."),
        Wish(4, "DJI Mavic 3 Pro", "A professional drone with a triple-camera system."),
        Wish(5, "Sony Alpha 7 IV", "A versatile full-frame mirrorless camera."),
        Wish(6, "Bose QuietComfort 45", "Noise-canceling headphones for immersive audio."),
        Wish(7, "iPad Pro (M2)", "A powerful tablet for creative professionals."),
        Wish(8, "MacBook Pro 16-inch (M2 Max)", "A high-performance laptop for demanding tasks."),
        Wish(9, "Nintendo Switch OLED", "A hybrid gaming console with an enhanced display."),
        Wish(10, "PlayStation 5", "A next-gen gaming console with stunning graphics."),
        Wish(11, "Xbox Series X", "A powerful gaming console with advanced features."),
        Wish(12, "GoPro HERO11 Black", "An action camera for capturing adventures."),
        Wish(13, "Garmin Fenix 7", "A multisport GPS smartwatch for outdoor activities."),
        Wish(14, "Kindle Paperwhite", "An e-reader with a glare-free display."),
        Wish(15, "Roomba j7+", "A robot vacuum with automatic dirt disposal."),
        Wish(16, "Nest Learning Thermostat", "A smart thermostat that learns your preferences."),
        Wish(17, "Sonos Arc", "A premium soundbar for home theater systems."),
        Wish(18, "LG C2 OLED TV", "A high-end OLED TV with stunning picture quality."),
        Wish(19, "Apple Watch Ultra", "A rugged smartwatch for extreme sports."),
        Wish(20, "AirPods Max", "Over-ear headphones with active noise cancellation."),
        Wish(21, "Steam Deck", "A portable PC gaming console."),
        Wish(22, "Oculus Quest 2 Elite Strap", "Enhanced comfort accessory for VR gaming."),
        Wish(23, "Peak Design Everyday Backpack", "A versatile camera and everyday backpack."),
        Wish(24, "Hydro Flask Water Bottle", "Insulated water bottle for hydration."),
        Wish(25, "Aeropress Coffee Maker", "A compact and efficient coffee brewing device."),
        Wish(26, "Le Creuset Dutch Oven", "A durable and stylish cast iron pot."),
        Wish(27, "Instant Pot Duo", "A multi-functional electric pressure cooker."),
        Wish(28, "Anker PowerCore Portable Charger", "A high-capacity portable battery."),
        Wish(29, "Philips Hue Smart Bulbs", "Smart lighting system for home automation."),
        Wish(30, "Logitech MX Master 3", "An advanced wireless mouse for productivity."),
        Wish(31, "Herman Miller Aeron Chair", "An ergonomic office chair for comfort."),
        Wish(32, "Standing Desk Converter", "Transform your desk into a standing desk."),
        Wish(33, "Mechanical Keyboard", "A customizable keyboard with tactile feedback."),
        Wish(34, "External SSD", "A fast and reliable storage solution."),
        Wish(35, "Noise-Canceling Earbuds", "Compact earbuds for immersive audio."),
        Wish(36, "Smart Garden", "A self-watering indoor garden system."),
        Wish(37, "Subscription Box Service", "Curated monthly box of goods."),
        Wish(38, "Personal Training Sessions", "Guided fitness and exercise routines."),
        Wish(39, "Cooking Class", "Learn to cook new cuisines and dishes."),
        Wish(40, "Language Learning Software", "Interactive language learning programs."),
        Wish(41, "Online Course", "Expand your knowledge and skills."),
        Wish(42, "Meditation App Subscription", "Guided mindfulness and relaxation exercises."),
        Wish(43, "Travel Experience", "Explore new places and cultures."),
        Wish(44, "Charity Donation", "Support a cause you believe in."),
        Wish(45, "Concert Tickets", "Experience live music from your favorite artists."),
        Wish(46, "Home Spa Kit", "Create a relaxing spa experience at home."),
        Wish(47, "Projector", "Enjoy movies and games on a large screen."),
        Wish(48, "High-Quality Binoculars", "Get closer to nature with improved optics."),
        Wish(49, "3D Printer", "Bring your creative designs to life."),
        Wish(50, "VR Gaming Rig", "Immerse yourself in the world of virtual reality."),
        Wish(51, "Telescope", "Explore the universe from your backyard."),
        Wish(52, "High-End Coffee Beans", "Enjoy premium coffee at home."),
    )
}
