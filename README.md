<h1 align="center">📝 Task Tracker CLI (Java)</h1>
<p align="center">
  <b>Track your tasks like a pro from the command line!</b><br>
  Built using <code>core Java</code> — no frameworks, no libraries, just raw logic.
</p>

---

## 🌟 Features

✅ Add a new task  
🛠️ Update task description  
❌ Delete a task  
🔄 Change task status (`TODO`, `IN_PROGRESS`, `DONE`)  
📋 List all tasks or filter by status  
💾 All data stored in `tasks.json`

---

## 🧰 Prerequisites

- ☕ Java 8 or higher
- 💻 Terminal / Command Prompt

---

## 🧠 How It Works

📦 **Project files**:
- `Task.java` → Task model (id, description, status, timestamps)
- `TaskManager.java` → Logic (add, update, delete, status, list)
- `TaskTracker.java` → CLI entry point (parses user input)

🗃️ Tasks are stored in `tasks.json`, auto-created in your current folder.

---

## 🧱 Setup & Usage

### 🪜 Step 1: Setup

Clone the repo or manually create the following files:
- `Task.java`
- `TaskManager.java`
- `TaskTracker.java`

### ⚙️ Step 2: Compile

```bash
javac Task.java TaskManager.java TaskTracker.java
```

### 🚀 Step 3: Run Commands

```bash
# ➕ Add a task
java TaskTracker add "Finish writing README"

# ✏️ Update a task
java TaskTracker update 1 "Push README to GitHub"

# ❌ Delete a task
java TaskTracker delete 1

# 🔁 Mark IN_PROGRESS
java TaskTracker in_progress 2

# ✅ Mark DONE
java TaskTracker done 2

# 📋 List all
java TaskTracker list

# 🎯 Filter by status
java TaskTracker list todo
java TaskTracker list in_progress
java TaskTracker list done
```

📝 The `tasks.json` file is automatically created and updated with each command.

---

## 📄 Task Format (in JSON)

```json
{
  "id": 1,
  "description": "Example task",
  "status": "TODO",
  "createdAt": "2024-06-22T18:30:00",
  "updatedAt": "2024-06-22T18:30:00"
}
```

---

## 🎓 What You'll Learn

- 🧩 Java CLI app structure
- 📂 File I/O with `File`, `FileWriter`, `Files.readAllBytes`
- 🧵 Manual JSON parsing
- 🧠 Date handling with `Date` & `LocalDateTime`
- 🛠️ Clean, modular code design

---

## 🚀 Future Enhancements

- 🗓️ Add due dates or priorities
- 📤 Export tasks to CSV
- 🧪 Add unit tests
- 🔄 Replace manual parsing with `Gson` or `Jackson`
- 🌐 Upgrade to React + Spring Boot for web interface

---

## 👩‍💻 Author

**Varsha Gajula**  
🎓 Pursuing M.Tech in Software Engineering  
💻 Full Stack Developer | Java • Python • AWS • React • Spring Boot • SQL  
📫 _Excited to learn, build, and grow!_

---

## 📜 License
Project URL: https://roadmap.sh/projects/task-tracker
This project is licensed for **educational and personal use**.  
Feel free to fork, modify, and improve it — just give credit where it’s due. 🌟

---

<p align="center">
  <b>✨ Happy Task Tracking! 🚀</b>
</p>
