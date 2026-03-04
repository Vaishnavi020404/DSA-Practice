import matplotlib.pyplot as plt
import matplotlib.dates as mdates
from datetime import datetime

# === Project Timeline Data ===
tasks = [
    ("Project Initialization & Planning", "2025-08-01", "2025-08-04"),
    ("Documentation – Phase 1 (Setup & Planning)", "2025-08-01", "2025-08-10"),
    ("Infrastructure & Identity Setup", "2025-08-05", "2025-08-18"),
    ("Active Directory Configuration", "2025-08-10", "2025-08-22"),
    ("SIEM Setup (Splunk Installation)", "2025-08-15", "2025-08-25"),
    ("Log Forwarding Setup", "2025-08-20", "2025-08-28"),
    ("Communication Integration (Slack Setup)", "2025-08-23", "2025-08-30"),
    ("Internal Testing & Verification – Phase 1", "2025-08-25", "2025-09-02"),
    ("Documentation – Phase 2 (Implementation Details)", "2025-08-20", "2025-09-10"),
    ("Project Review 1 (Department Evaluation)", "2025-09-11", "2025-09-11"),
    ("Post-Review Improvements", "2025-09-12", "2025-09-20"),
    ("SOAR Integration (Shuffle Setup)", "2025-09-15", "2025-09-25"),
    ("Automation Testing & Alert Validation", "2025-09-22", "2025-09-28"),
    ("Final Integration & Security Hardening", "2025-09-26", "2025-10-01"),
    ("Documentation – Final Report Compilation", "2025-08-01", "2025-10-06"),
    ("Project Review 2 & Submission", "2025-10-05", "2025-10-05"),
]

# Convert to datetime
for i in range(len(tasks)):
    tasks[i] = (
        tasks[i][0],
        datetime.strptime(tasks[i][1], "%Y-%m-%d"),
        datetime.strptime(tasks[i][2], "%Y-%m-%d")
    )

# === Sort by Start Date (earliest first) ===
tasks.sort(key=lambda x: x[1])

# === Plot Configuration ===
fig, ax = plt.subplots(figsize=(13, 8))
colors = plt.cm.tab20.colors

remark = ""

for i, (task, start, end) in enumerate(tasks):
    ax.barh(i, (end - start).days, left=start, color=colors[i % len(colors)], edgecolor='black')
    ax.text(end, i, f"  {remark}", va='center', ha='left', fontsize=9)

# Y-axis labels
ax.set_yticks(range(len(tasks)))
ax.set_yticklabels([t[0] for t in tasks], fontsize=9)

# X-axis formatting
ax.xaxis.set_major_formatter(mdates.DateFormatter("%b %d"))
ax.xaxis.set_major_locator(mdates.WeekdayLocator(interval=1))
plt.xticks(rotation=45, fontsize=9)

# Titles & Labels
ax.set_xlabel("Timeline", fontsize=11)
ax.set_title("Project Timeline", fontsize=14, fontweight="bold")

# Grid & Style
ax.grid(True, axis='x', linestyle='--', alpha=0.6)
plt.tight_layout()
plt.gca().invert_yaxis()  # earliest at top
plt.show()